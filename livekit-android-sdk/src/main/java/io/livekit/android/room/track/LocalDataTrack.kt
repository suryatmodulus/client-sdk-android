package io.livekit.android.room.track

import org.webrtc.DataChannel
import java.nio.ByteBuffer

class LocalDataTrack(
    val options: DataTrackOptions,
    rtcTrack: DataChannel
) : DataTrack(options.name, rtcTrack) {
    var sid: Sid? = null
        internal set

    fun sendString(message: String) {
        val byteBuffer = ByteBuffer.wrap(message.toByteArray())
        val buffer = DataChannel.Buffer(byteBuffer, false)
        rtcTrack.send(buffer)
    }

    fun sendBytes(byteBuffer: ByteBuffer) {
        val buffer = DataChannel.Buffer(byteBuffer, true)
        rtcTrack.send(buffer)
    }
}