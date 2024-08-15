import software.amazon.awscdk.App
import software.amazon.awscdk.Environment
import software.amazon.awscdk.StackProps

fun main() {
    val app = App()

    val context = app.node.getContext("environment") as String
    val fargateAppProps = EnvironmentDataResolver.resolve(context)
    if(fargateAppProps!=null) {
        Stack(
            app, "josh-fargate",
            StackProps.builder().env(
                Environment.builder()
                    .account("033512919333")
                    .region("us-east-1").build()
            ).build(), fargateAppProps
        )
    }
    app.synth()
}