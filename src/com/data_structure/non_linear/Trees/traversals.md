### Traversing Trees Approaches

1. Breadth first (Level order traversal)

2. Depth First
   1. Pre-Order _(**Root**, Left, Right)_
   2. In-Order _(Left, **Root**, Right)_ 
   3. Post-Order _(Left, Right, **Root**)_


<br />

### Depth and Height

**Depth** = Number of edges from the root to the target node.

**Height** =  Number of edges on the longest path from the node to a leaf node.
_The height of the root node is the height of the tree._

<br />

Formula to calculate height of a node: `1 + max(height(L), height(R))`