#Nearest Prime Numbers
#Description
#A prime number is any integer greater than 1 which can only be evenly divided by 1 or itself.
# For this challenge, you will output two numbers: the nearest prime below the input,
# and the nearest prime above it.
#Input Description
#The input will be a number on each line, called n.
#Output Description
#The format of the output will be:
#p1 < n < p2
#where p1 is the smaller prime, p2 is the larger prime and n is the input.
#If n already is a prime, the output will be:
#n is prime.
#Challenge Input
#270 541  993  649
#Challenge Output
#269 < 270 < 271  541 is prime.  991 < 993 < 997  647 < 649 < 653
#Bonus
#Write the program to work for numbers with big gaps to the nearest primes.
#This requires a clever solution and cannot be efficiently bruteforced.
#2010741
#1425172824437700148
#https://www.reddit.com/r/dailyprogrammer/comments/6s70oh/2017087_challenge_326_easy_nearest_prime_numbers/
from random import randrange

def isprime(n):
    for i in range(n):
        if n%i == 0:
            return False
        

def NearestPrime(n):
    min = False
    max = False
    while min == False and max == False:
        pass
def miller_rabin(n, k=10):
	if n == 2 or n == 3:
    		return True
	if not n & 1:
		return False
	def check(a, s, d, n):
		x = pow(a, d, n)
		if x == 1:
			return True
		for i in range(s - 1):
			if x == n - 1:
				return True
			x = pow(x, 2, n)
		return x == n - 1
	s = 0
	d = n - 1
	while d % 2 == 0:
		d >>= 1
		s += 1
	for i in range(k):
		a = randrange(2, n - 1)
		if not check(a, s, d, n):
			return False
	return True

print(NearestPrime(270),NearestPrime(541),NearestPrime(993),NearestPrime(649))