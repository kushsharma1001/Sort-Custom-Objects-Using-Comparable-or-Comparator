# Sort-Custom-Objects-Using-Comparable-or-Comparator
How to sort custom objects in Java


## Points to Note :
1) By default, Arrays.sort() or Collections.sort() methods internally uses compareTo() method definition to perform comparision.
2) If we do not implement Comparable and override the compareTo() method, then Arrays.sort() or Collections.sort() throws exception for custom objects cannot be sorted. Also, remember that compareTo() method takes 1 arg only.
2) We can always provide our own comparator name in Arrays.sort() or Collections.sort() methods but we should override the compare() method using comparators. Also, remember that compare() method should take 2 args.
3) We can also implement the comparator interface and then directly override the compare method (just the same way as what we did with comparable).. But then, we need to pass the object of the class implementing the comparator interface in Arrays.sort() or Collections.sort() method as comparator name will not be there if we directly override the compare method by implementing the comparator interface.
