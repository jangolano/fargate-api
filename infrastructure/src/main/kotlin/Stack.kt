import software.amazon.awscdk.Stack
import software.amazon.awscdk.StackProps
import software.amazon.awscdk.services.ec2.*
import software.amazon.awscdk.services.ecr.Repository
import software.amazon.awscdk.services.ecr.assets.DockerImageAsset
import software.amazon.awscdk.services.ecr.assets.DockerImageAssetProps
import software.amazon.awscdk.services.ecs.Cluster
import software.amazon.awscdk.services.ecs.ClusterProps
import software.amazon.awscdk.services.ecs.ContainerImage
import software.amazon.awscdk.services.ecs.EcrImage
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedFargateService
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedTaskImageOptions
import software.constructs.Construct


class Stack(scope: Construct, id: String, props: StackProps, instanceProps:FargateAppProps) : Stack(scope, id, props) {

    init {
        val vpc = Vpc.fromVpcAttributes(
            this, "josh-default-vpc",
            VpcAttributes.Builder().publicSubnetIds(instanceProps.publicSubnets)
                .privateSubnetIds(instanceProps.privateSubnets)
                .availabilityZones(instanceProps.availabilityZones)
                .vpcId(instanceProps.vpcId).build()
        )

        val cluster = Cluster(this, "my-test-cluster", ClusterProps.builder().vpc(vpc).build())

        val repository =
            Repository.fromRepositoryArn(this, "ecr-repo", "arn:aws:ecr:us-east-1:033512919333:repository/fargate-api")


        val securityGroup = SecurityGroup.Builder.create(this, "fargate-api-security-group")
            .vpc(vpc).build()
        securityGroup.addEgressRule(Peer.anyIpv4(), Port.allTcp())
        securityGroup.addIngressRule(Peer.anyIpv4(), Port.allTcp())
        ApplicationLoadBalancedFargateService.Builder.create(this, "Service")
            .cluster(cluster)
            .memoryLimitMiB(1024)
            .desiredCount(1)
            .cpu(512).securityGroups(listOf(securityGroup))
            .taskImageOptions(
                ApplicationLoadBalancedTaskImageOptions.builder()
                    .image(ContainerImage.fromEcrRepository(repository, "latest")).containerPort(8080)
                    .build()
            )
            .taskSubnets(
                SubnetSelection.builder().subnetType(SubnetType.PRIVATE_WITH_EGRESS)
                    .build()
            )
            .loadBalancerName("josh-load-balanced")
            .build()

    }
}