package com.prakti.model;

enum Skill {
    JAVA("Java"),
    CSHARP("C#"),
    C("C"),
    ANGULAR("Angular"),
    QUARKUS("Quarkus"),
    PYTHON("Python"),
    DJANGO("Django"),
    FLASK("Flask"),
    KOTLIN("Kotlin"),
    ANDROID("Android"),
    SWIFT("Swift");

    private final String value;
    Skill(String value)
    {
        this.value = value;
    }

    public String toString()
    {
        return this.value;
    }
}
