Given a calculator

When set arguments to 10.5555 and 1.1111 
Then adding should return 11.6666

When set arguments to -1.1 and -2.2
Then adding should return -3.3

When set arguments to 10.5555 and 1.1111
Then subtracting should return 9.4444

When set arguments to 5.555 and 0
Then multiplying should return 0

When set arguments to 5.555 and 1.000
Then dividing should return 5.555

When set arguments to 3.101 and 3.077
Then comparison should return true

When set arguments to 3.077 and 3.101
Then comparison should return false

When 2.888 is divided by 0
Then infinity is returned
