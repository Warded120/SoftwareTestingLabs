Lab1:
- every class must be in a separate file 
- humanIMB should be public
- blank lines at the start of a file should be removed
- strange comments at the start of a lab1.Main class, they may be removed
- accessing static method humanBmi.Result() via instance
- humanIMB class should follow PascalCase, it should be renamed to lab1.HumanBmi
- all instance-specific (non-static) fields must be private
- fields, constructors, methods, getters and setters must be grouped. Meaning declare all fields at first, then all constructors, then all methods, then all getters and setters 
- rename all take\put methods to get\set
- getters\setters should not be static
- 'String string = null' variable name is not informative
- String should not be initialized with null, it is better to be declared without value
- you can return inline variable instead of assigning String var
- fields' and methods' names should be more informative. rename Result() to getResult(), W to weight, H to height etc. 
- imb field should not be written backwards (better is bmi or bodyWeightIndex). thus HumanImb should be renamed to lab1.HumanBmi
- bodyWeightIndex field may be deleted and its value be calculated dynamically to reduce memory usage
- Result() method is instance specific, it should be non-static
- 4 if statements may be changed to else-if chain
- else-if statements may be relocated to be more readable
- getResult() method may return inline vars instead of assigning value to variable
- use && instead of & operator
- whitespace in string literal: string ="Warning! "
- missing whitespace between operators '>=', '<', '=' and values: bodyWeightIndex >=18.5. should be bodyWeightIndex >= 18.5, string ="Warning! " should be string = "Warning!" etc.
