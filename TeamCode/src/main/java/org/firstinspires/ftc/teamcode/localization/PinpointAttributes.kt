@file:JvmName("PinpointAttributes")

package org.firstinspires.ftc.teamcode.localization

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver

data class PinpointAttributes(
    val deviceName: String,

    val forwardPodOffset: Double,
    val strafePodOffset: Double,

    val forwardPodDirection: GoBildaPinpointDriver.EncoderDirection,
    val strafePodDirection: GoBildaPinpointDriver.EncoderDirection
)