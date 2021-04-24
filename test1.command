#! /bin/bash
java -jar lib/sablecc.jar grammar.txt
javac graphlang/Compiler.java
java graphlang.Compiler input.txt