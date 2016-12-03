Given a calculator

When set arguments to 2 and 3
Then adding should return 5

When set arguments to -1 and -2
Then adding should return -3

When set arguments to 5 and 6
Then subtracting should return -1

When set arguments to 5 and 0
Then multiplying should return 0

When set arguments to 5 and 3
Then dividing should return 1

When set arguments to 2 and 0
Then dividing should return 0

When set arguments to 5 and 3
Then comparison should return true

When set arguments to 3 and 5
Then comparison should return false

