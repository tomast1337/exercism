#                               Description
#A number is input in computer then a new no should get printed by adding one to each of its digit.
#If you encounter a 9, insert a 10 (don't carry over, just shift things around).
#For example, 998 becomes 10109.
#                               Bonus
#This challenge is trivial to do if you map it to a string to iterate over the input,
#operate, and then cast it back. Instead,
#try doing it without casting it as a string at any point,
#keep it numeric (int, float if you need it) only.
#https://www.reddit.com/r/dailyprogrammer/comments/aphavc/20190211_challenge_375_easy_print_a_new_number_by/
def thingNomarl(x):
    x = str(x)
    final = ""
    for i in x:
        i = int(i) + 1
        final = final + str(i)
    return int(final)

def thingBonus(x):
    numbers = []
    p = 1
    while p < x:
        numbers.append(x/10)
        p = p * 10
    print(numbers)
    return 0
print(thingBonus(998))