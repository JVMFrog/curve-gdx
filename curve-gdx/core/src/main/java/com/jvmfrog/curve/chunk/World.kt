package com.jvmfrog.curve.chunk

import kotlin.math.absoluteValue

@Suppress("UNCHECKED_CAST")
class World<T : Any>(private val loadedWorldSize: Int, private val chunkSize: Int, chunkConstructor: () -> Chunk) {
    private val loadedWorld = Array(loadedWorldSize) { Array(loadedWorldSize) { chunkConstructor() } }
    private val worldSizeInBlock = loadedWorldSize * chunkSize

    private var oldX = 0
    private var oldY = 0
    private var needToUpdate = true;

    var loadedXCenter = 0
        set(value) {
            needToUpdate = needToUpdate || oldX != loadedXCenter;
            oldX = loadedXCenter;
            field = value
        }

    var loadedYCenter = 0
        set(value) {
            needToUpdate = needToUpdate || oldY!= loadedYCenter;
            oldY = loadedYCenter;
            field = value
        }

    fun getBlock(x: Int, y: Int): T {
        val newX = x % worldSizeInBlock
        val newY = y % worldSizeInBlock
        return loadedWorld[newX / chunkSize][newY / chunkSize].getBlock(
            newX - (newX / chunkSize) * chunkSize,
            newY - (newY / chunkSize) * chunkSize
        ) as T
    }

    fun setBlock(x: Int, y: Int, block: T) {
        val newX = x % worldSizeInBlock
        val newY = y % worldSizeInBlock
        loadedWorld[newX / chunkSize][newY / chunkSize].setBlock(
            newX - (newX / chunkSize) * chunkSize,
            newY - (newY / chunkSize) * chunkSize,
            block
        )
    }

    fun update() {
        if(!needToUpdate) return;

        val distX = loadedXCenter - oldX;
        val distY = loadedYCenter - oldY;

        if (distX.absoluteValue < worldSizeInBlock && distY.absoluteValue < worldSizeInBlock) {

        }
    }
}