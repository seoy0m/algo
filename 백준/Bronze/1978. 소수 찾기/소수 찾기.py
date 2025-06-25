t= int(input())
input_list= list(map(int, input().split()))

prime =0
for num in input_list:
    count = 0
    for i in range(1,num+1):
        if num % i == 0:
            count += 1

        if count == 2 and i == num:
            prime +=1

print(prime)