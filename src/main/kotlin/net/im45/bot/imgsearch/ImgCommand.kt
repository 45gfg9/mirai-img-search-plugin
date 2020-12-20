package net.im45.bot.imgsearch

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.console.command.UserCommandSender
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.buildMessageChain
import net.mamoe.mirai.message.data.queryUrl
import java.nio.file.Files

object ImgCommand : CompositeCommand(
        ImgSearch, "img"
) {
    @SubCommand("search", "s")
    suspend fun UserCommandSender.search(img: Image) {
        val url = img.queryUrl()
        val get = HttpClient(CIO).get<ByteArray>(url)
        val file = Files.createTempFile(null, null)
                .toFile()
        file.deleteOnExit()
        file.writeBytes(get)

        sendMessage(buildMessageChain {
            +(url + "\n")
            +img
            +"\n"
            +(img.imageId + "\n")
            +file.absolutePath
        })
    }
}