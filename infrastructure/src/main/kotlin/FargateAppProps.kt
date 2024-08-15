import software.amazon.awscdk.StackProps

data class FargateAppProps(val privateSubnets: List<String>,
                           val publicSubnets: List<String>,
                           val availabilityZones: List<String>,
                            val vpcId: String) : StackProps