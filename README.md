# The Gift Wrapping Algorithm

### Contributors
* [Jacob McKinnis](https://github.com/JacobMckinnis)
* [Nathan Stoner](https://github.com/Naxhi)

This short Java program uses a timed Gift Wrapping algorithm to calculate 
the smallest possible convex hull around a set of random points.
This is useful for things like video game collision detection
and calculating the center of balance for irregularly shaped objects.

The idea of the gift wrapping algorithm is to "wrap" the points together
by checking each point on the hull against all the other points and 
finding the best possible point to add to the hull.

This approach takes O(nk) time where k is the number of random points.
This algorithm's performance is greatly impacted by its input.

While this algorithm is good, it is not the most optimal algorithm
for calculating convex hulls. We found that Graham Scan is a better
algorithm in the long run, but requires more space than Gift Wrapping.
