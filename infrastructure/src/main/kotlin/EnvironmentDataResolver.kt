object EnvironmentDataResolver {
    fun resolve(environment: String): FargateAppProps?{
        when(environment){
            "dev"->return FargateAppProps(
                privateSubnets = listOf("subnet-090b4f0c8329865c1", "subnet-022a0d057293172bf"),
                publicSubnets = listOf("subnet-06c67d430a33ac72c", "subnet-097efab21f5782274"),
                availabilityZones = listOf("us-east-1a", "us-east-2a"),
                vpcId = "vpc-06eedfeb8b8e09563"
            )
        }
        return null
    }
}