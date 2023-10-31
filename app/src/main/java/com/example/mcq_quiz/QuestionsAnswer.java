package com.example.mcq_quiz;

public class QuestionsAnswer {

    public static String questions[] = {
            //  JAVA
            "Q1.   Which of the following is not a Java features?",
            "Q2.  _____ is used to find and fix bugs in the Java programs.?",
            "Q3.  What does the expression float a = 35 / 0 return?",
            "Q4.  In which process, a local variable has the same name as one of the instance variables?",
            "Q5.  Which package contains the Random class?",

            //HTML
            "Q1.  Which of the following element is responsible for making the text bold in HTML?",
            "Q2.  Which of the following tag is used for inserting the largest heading in HTML?",
            "Q3.  Which of the following tag is used to insert a line-break in HTML?",
            "Q4.  How to create an unordered list (a list with the list items in bullets) in HTML?",
            "Q5.  Which character is used to represent the closing of a tag in HTML?",

            //JavaScript
            "Q1.  Which type of JavaScript language is ___?",
            "Q2.  When interpreter encounters an empty statements, what it will do:?",
            "Q3.  The \"function\" and \" var\" are known as:",
            "Q4.  Which of the following option is used as hexadecimal literal beginning?",
            "Q5.  Which of the following type of a variable is volatile?",

            // Python
            "Q1.  Who developed the Python language?",
            "Q2.  In which year was the Python language developed?",
            "Q3.  Which one of the following is the correct extension of the Python file?",
            "Q4.  Which character is used in Python to make a single line comment?",
            "Q5.  What is the method inside the class in python language?"
    };

    public static String choices[][] = {
            {"Dynamic", "Architecture Neutral", "Use of pointers", "Object-oriented"},
            {"JVM", "JRE", "JDK", "JDB"},
            {"0", "Not a Number", "Infinity", "Run time exception"},
            {"Serialization", "Variable Shadowing", "Abstraction", "Multi-threading"},
            {"java.util package", "java.lang package", "java.awt package", "java.io package"},

            {"<pre>", "<a>", "<b>", "<br>"},
            {"<h3>", "<h1>", "<h5>", "<h6>"},
            {"<br>", "<a>", "<pre>", "<b>"},
            {"<ul>", "<ol>", "<li>", "<i>"},
            {";", "!", "/", "."},

            {"Object-Oriented", "Object-Based", "Assembly-language", "High-level"},
            {"Shows a warning", "Prompts to complete the statement", "Throws an error", "Ignores the statements"},
            {"Keywords", "Data types", "Declaration statements", "Prototypes"},
            {"00", "0x", "0X", "Both 0x and 0X"},
            {"Mutable variable", "Dynamic variable", "Volatile variable", "Immutable variable"},

            {"Zim Den", "Guido van Rossum", "Niene Stom", "Wick van Rossum"},
            {"1995", "1972", "1981", "1989"},
            {".py", ".python", ".p", "None of these"},
            {"/", "//", "#", "!"},
            {"Object", "Function", "Attribute", "Argument"}
    };

    public static String answers[] = {
            "Use of pointers",
            "JDB",
            "Infinity",
            "Variable Shadowing",
            "java.util package",

            "<b>",
            "<h1>",
            "<br>",
            "<ul>",
            "/",

            "Object-Based",
            "Ignores the statements",
            "Declaration statements",
            "Both 0x and 0X",
            "Mutable variable",

            "Guido van Rossum",
            "1989",
            ".py",
            "#",
            "Function"
    };
}