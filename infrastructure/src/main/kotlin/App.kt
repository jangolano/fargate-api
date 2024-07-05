import software.amazon.awscdk.App
import software.amazon.awscdk.StackProps

fun main() {
    val app = App()
    Stack(app, "cdk-sample", StackProps.builder().build())
    app.synth()
}