class Solution {
public int sumCounts(List<Integer> arr) {
int sum = arr.size();
for (int i = 0; i < arr.size(); i++) {
HashSet<Integer> ms = new HashSet<>();
ms.add(arr.get(i));
for (int j = i + 1; j < arr.size(); j++) {
ms.add(arr.get(j));
sum += ms.size() * ms.size();
}
}
return sum;
}
}