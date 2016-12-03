Given liczba

When set argument to 1
Then the result of conversion should be I

When set argument to 3999
Then the result of conversion should be MMMCMXCIX

When set argument to 888
Then the result of conversion should be DCCCLXXXVIII

When set illegal argument like 0
Then an exception is thrown

When set illegal argument like 4000
Then an exception is thrown






