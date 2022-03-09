package com.jvmfrog.curve.registry

class IDManager {
    companion object {
        private val groups = mutableMapOf<String, IDGroup>()

        @JvmStatic
        fun newGroup(name: String) {
            groups[name] = IDGroup()
        }

        @JvmStatic
        fun newID(string: String): Int {
            val parts = string.split(":")
            val idGroup = groups[parts[0]] ?: throw NoSuchElementException("group ${parts[0]} is not found")
            val id = idGroup.lastID++
            idGroup.ids[parts[1]] = id
            return id
        }

        @JvmStatic
        operator fun get(string: String): Int {
            val parts = string.split(":")
            val idGroup = groups[parts[0]] ?: throw NoSuchElementException("group ${parts[0]} is not found")
            return idGroup.ids[parts[1]] ?: throw NoSuchElementException("id $string is not found")
        }
    }

    private class IDGroup(var lastID: Int = 0, val ids: MutableMap<String, Int> = mutableMapOf())
}