# 题目
一个排好序的数组，找出两数之和为m的所有组合
# 思路
1. 假设x+y=m, 则y=m-x,只要把数组遍历一遍，依据关系式求得y的值即可
# 优化
1. 假设遍历到 m/2 即可，因为后面的组合已经和前面的重复了。
2.