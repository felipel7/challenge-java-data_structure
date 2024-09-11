### Graphs Approach

1. Adjacency Matrix
   >  A 2-dimensional array that represents how nodes are connected.

2. Adjacency List
   > An array of linked lists

<br>
<br>

Time complexity for the average scenario:

<table>
   <thead>
      <th> </th>
      <th>Matrix</th>
      <th>List</th>
   </thead>
   <tbody>
      <tr>
         <td>Space</td>
         <td>O(n²)</td>
         <td>O(V + E)</td>      
      </tr>
      <tr>
         <td>Add Edge</td>
         <td>O(1)</td>
         <td>O(K)</td>      
      </tr>
      <tr>
         <td>Remove Edge</td>
         <td>O(1)</td>
         <td>O(K)</td>      
      </tr>
      <tr>
         <td>Query Edge</td>
         <td>O(1)</td>
         <td>O(K)</td>      
      </tr>
      <tr>
         <td>Find Neighbors</td>
         <td>O(V)</td>
         <td>O(K)</td>      
      </tr>
      <tr>
         <td>Add Node</td>
         <td>O(V²)</td>
         <td>O(1)</td>      
      </tr>
      <tr>
         <td>Remove Node</td>
         <td>O(V²)</td>
         <td>O(V²)</td>      
      </tr>
   </tbody>
</table>

<br>

Time complexity for worst case scenario:

<table>
   <thead>
      <th> </th>
      <th>Matrix</th>
      <th>List</th>
   </thead>
   <tbody>
      <tr>
         <td>Space</td>
         <td>O(V²)</td>
         <td>O(V²)</td>      
      </tr>
      <tr>
         <td>Add Edge</td>
         <td>O(1)</td>
         <td>O(V)</td>      
      </tr>
      <tr>
         <td>Remove Edge</td>
         <td>O(1)</td>
         <td>O(V)</td>      
      </tr>
      <tr>
         <td>Query Edge</td>
         <td>O(1)</td>
         <td>O(V)</td>      
      </tr>
      <tr>
         <td>Find Neighbors</td>
         <td>O(V)</td>
         <td>O(V)</td>      
      </tr>
      <tr>
         <td>Add Node</td>
         <td>O(V²)</td>
         <td>O(1)</td>      
      </tr>
      <tr>
         <td>Remove Node</td>
         <td>O(V²)</td>
         <td>O(V²)</td>      
      </tr>
   </tbody>
</table>

