package de.kpaw.visualreach

import net.minecraft.util.math.Box
import net.minecraft.util.math.Vec3d

object VisualReachUtils {

    fun nearestPointForBox(from: Vec3d, box: Box) = Vec3d(
        clamp(from.x, box.minX, box.maxX),
        clamp(from.y, box.minY, box.maxY),
        clamp(from.z, box.minZ, box.maxZ)
    )

    private fun clamp(t: Double, a: Double, b: Double) = when {
        t <= a -> a
        t in a..b -> t
        b <= t -> b
        else -> throw IllegalStateException("Else branch got used in clamp") // should never be the case
    }
}