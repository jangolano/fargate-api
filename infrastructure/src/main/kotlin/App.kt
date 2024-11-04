import software.amazon.awscdk.App
import software.amazon.awscdk.Environment
import software.amazon.awscdk.StackProps

fun main() {
    val app = App()

    Stack(
        app, "josh-fargate",
        StackProps.builder().build()
    )

    app.synth()
}