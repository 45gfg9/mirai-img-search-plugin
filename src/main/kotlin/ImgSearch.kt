import com.google.auto.service.AutoService
import net.mamoe.mirai.console.plugin.jvm.JvmPlugin
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin

@AutoService(JvmPlugin::class)
object ImgSearch : KotlinPlugin(
        JvmPluginDescription(
                "net.im45.bot.imgsearch",
                "0.1",
                "Image Searcher"
        )
)