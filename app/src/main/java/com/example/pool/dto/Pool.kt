package com.example.pool.dto

/**
 * A Pool object
 *
 * @property name, a string to identify this pool
 * @property poolGallonSize, the volume of this pool in gallons
 *
 * @property isIndoorPool, not sure if this would matter, but made it an optional field anyway
 */
class Pool(val name: String, val poolGallonSize: Float, val isIndoorPool: Boolean = false) {
}