package com.jvmfrog.curve.chunk

interface Chunk {
    fun getBlock(x: Int, y: Int): Any
    fun setBlock(x: Int, y: Int, block: Any)
    fun load(chunkX: Int, chunkY: Int);
}