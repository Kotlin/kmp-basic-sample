class Calculator {
    companion object {
        fun sum(a: Int, b: Int): Int = a + b;

        internal val myMap: Map<String, List<String>> = mapOf(
                "val1" to listOf("a1", "a2", "a3"),
                "val2" to listOf("b1", "b2")
        );

        fun getName(name: String): String {
            for (entry in myMap) {
                if (entry.value.contains(name)) {
                    return entry.key;
                }
            }

            return name;
        }
    }


}