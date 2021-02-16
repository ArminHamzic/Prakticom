package com.prakti.model;
//Deprecated
enum SkillValue {
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
    SkillValue(String value)
    {
        this.value = value;
    }

    public String toString()
    {
        return this.value;
    }
}
