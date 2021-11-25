package interview_prep

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.ArrayList


/*
     0  1  2  3  4  5  6
  0     2  2
  1  .        1  5
  2  .              6  3
  3     .
  4     .
  5       .
  6       .
 */

/*
     0  1  2  3  4  5  6
  0     2  2
  1  .        1  5
  2  .              6  3
  3     .
  4     .
  5       .
  6       .
 */
fun main() {
/*
  val arr = arrayOf(
    arrayOf(0, 2, 2, 0, 0, 0, 0),
    arrayOf(2, 0, 0, 1, 5, 0, 0),
    arrayOf(2, 0, 0, 0, 0, 6, 3),
    arrayOf(0, 1, 0, 0, 0, 0, 0),
    arrayOf(0, 5, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 6, 0, 0, 0, 0),
    arrayOf(0, 0, 3, 0, 0, 0, 0),
  )
  val startNode = makeTree(arr)!!
  val dist1 = dfsNode2(startNode, 5)
  val dist2 = dfsNode2Shortest(startNode, 5)
  val dist3 = bfsNode2(startNode, 5)
  println(dist1)
  println(dist2)
  println(dist3)
 */

  /*
          1   2   3   4   5   6
      1       3       1
      2   3               5   3
      3               1   1   1
      4   1        1          1
      5       5    1
      6       3    1   1
   */
  fun stdStr(result: List<Pair<Int, String>>): String = result.joinToString { "${it.second}:${it.first}" }
  val arr2 = arrayOf(
    arrayOf(0, 3, 0, 1, 0, 0),
    arrayOf(3, 0, 0, 0, 5, 3),
    arrayOf(0, 0, 0, 1, 1, 1),
    arrayOf(1, 0, 1, 0, 0, 1),
    arrayOf(0, 5, 1, 0, 0, 0),
    arrayOf(0, 3, 1, 1, 0, 0),
  )
  val startNode2 = makeTree(arr2, Array(arr2.size) { it+1 })!!

  val dist2_1 = bfsNode2Routes(startNode2, 5)
  val dist2_2 = dfsNode2Routes(startNode2, 5)
  val dist2_3 = dfsNode2(startNode2, 5)

  println("Connected Web ==== 2")
  println("startNode2 = $startNode2")
  println(stdStr(dist2_1))
  println(stdStr(dist2_2))
  println(dist2_3)

  val startNode3 = startNode2.next(6)!!
  val dist3_1 = bfsNode2Routes(startNode3, 5)
  val dist3_2 = dfsNode2Routes(startNode3, 5)
  val dist3_3 = dfsNode2(startNode3, 5)

  println("Connected Web === 3")
  println("startNode3 = $startNode3")
  println(stdStr(dist3_1))
  println(stdStr(dist3_2))
  println(dist3_3)


  val arrHackerRank = arrayOf(
    arrayOf(2,1),
    arrayOf(1,4),
    arrayOf(4,6),
    arrayOf(3,4),
    arrayOf(3,6),
    arrayOf(3,5),
    arrayOf(2,6),
    arrayOf(5,2),
  )
  val distances = bfs(6, 8, arrHackerRank, 1)
  println("from hackerrank distances = ${distances.joinToString()}")

  val arrHackerRank2 = arrayOf(
    arrayOf(1,2),
    arrayOf(1,3),
  )
  val distances2 = bfs(4, 2, arrHackerRank2, 1)
  println("from hackerrank distances2 = ${distances2.joinToString()}")

  val arrHackerRank3 = arrayOf(
    arrayOf(2,3),
  )
  val distances3 = bfs(3, 1, arrHackerRank3, 2)
  println("from hackerrank distances3 = ${distances3.joinToString()}")
}

/*
/**
 * Returns the distance from [start] to [dest].
 *
 */
fun bfs3(
  distanceMatrix: Array<Array<Int>>,
  start: Int,
  dest: Int,
): Int {
  if(distanceMatrix.isEmpty()) {
    return
  }
  val queue = LinkedList<Array<Int>>()
  var now: Array<Int>

  var rootNo = 0
  queue.push(distanceMatrix.first())

  while(queue.isNotEmpty()) {
    now = queue.pop()
    for(i in now) {
      if(i > 0) {
        queue.push(distanceMatrix[i])
      }
    }
  }
}
 */

/**
 * Returns start node. Returns null if all node aren't connected.
 */
fun makeTree(distanceMatrix: Array<Array<Int>>, nodeNumbers: Array<Int>? = null): Node? {
  fun isSquare(): Boolean = distanceMatrix.all { it.size == distanceMatrix.size }
  if(!isSquare()) {
    throw IllegalArgumentException("`distanceMatrix` must be square")
  }
  if(nodeNumbers?.let { it.size != distanceMatrix.size } == true) {
    throw IllegalArgumentException("`nodeNumbers` is not null but its size is not same as size of `distanceMatrix`")
  }

  val nodeArray = Array(distanceMatrix.size) {
    Node(nodeNumbers?.get(it) ?: it, mutableListOf())
  }
  for(i in distanceMatrix.indices) {
    for(u in i+1 until distanceMatrix[i].size) {
      if(distanceMatrix[i][u] > 0) {
        (nodeArray[i].neighbours as MutableList) += NodeEdge(nodeArray[u], distanceMatrix[i][u])
        (nodeArray[u].neighbours as MutableList) += NodeEdge(nodeArray[i], distanceMatrix[u][i]) // `nDistances[u]`, because the distance is symetric.
      }
    }
  }
  return nodeArray.find { it.neighbours.isNotEmpty() }
}

/**
 * Interface that only knows about inserting and removing one [T] item
 * at a time and doesn't care how to store the [T], that includes the order
 * of popping (LIFO or FIFO).
 */
interface Buffer<T>: Collection<T> {
  fun push(item: T): T
  fun pop(): T?

}

fun <T> Stack<T>.toBuffer(): Buffer<T> = object: Buffer<T>, Collection<T> by this {
  override fun push(item: T): T = this@toBuffer.push(item)
  override fun pop(): T? = this@toBuffer.pop()
}
fun <T> Queue<T>.toBuffer(): Buffer<T> = object: Buffer<T>, Collection<T> by this {
  override fun push(item: T): T {
    this@toBuffer.add(item)
    return item
  }
  override fun pop(): T? = this@toBuffer.poll()
}
fun <T> Buffer(stack: Stack<T>): Buffer<T> = stack.toBuffer()
fun <T> Buffer(queue: Queue<T>): Buffer<T> = queue.toBuffer()

interface INode {
  val no: Int
  val neighbours: List<NodeEdge>

  fun next(no: Int): INode?
}
data class Node(
  override val no: Int,
  override val neighbours: List<NodeEdge>,
): INode {
  //private var intoString = false
  override fun next(no: Int): INode? = bfsSearch(this, no)

  override fun toString(): String =
    "Node(no=$no, neighbours=${neighbours.joinToString(prefix = "[", postfix = "]") { "(no=${it.node.no}, distance=${it.distance})" }})"
}
data class NodeEdge(
  val node: INode,
  val distance: Int,
)

/**
 * This is fun template from HackerRank
 *
 *
 * Complete the 'bfs' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n -> node count
 *  2. INTEGER m -> edge count
 *  3. 2D_INTEGER_ARRAY edges -> pair of connected nodes, node number starts from 0 to n (inclusive).
 *  4. INTEGER s -> start node number
 */
//TODO: Still timeout for n= 446 m= 30338 s= 274, n= 224 m= 23724 s= 171
fun bfs(n: Int, m: Int, edges: Array<Array<Int>>, s: Int): Array<Int> {
  // Write your code here
  val buffer = LinkedList<Pair<Int, Int>>()
  buffer.push(Pair(s, 0/*, s.toString()*/))

  val distances = Array(n-1) { -1 }

  var now: Pair<Int, Int>
  //var prev: Triple<Int, Int, String>? = null
  fun distIndex(i: Int) = if(i < s) i-1 else i-2

  val mutEdge = edges.asList().toMutableList()
  var edgeItr= mutEdge.listIterator()

  val travelledNode = mutableSetOf<Int>()
  var calculatedDistances = 0

  out@ while(buffer.isNotEmpty()) {
    now = buffer.pop()
    travelledNode += now.first
    //println("now = $now")
    for(e in edgeItr) {
      //println("e = ${e.joinToString()}")
      if(e[0] == now.first || e[1] == now.first) {
        val node = if(e[0] == now.first) e[1] else e[0]
        //println("node= $node travelledNode= $travelledNode")
        //println("buffer = $buffer")
        //if(node == s) { continue }
        ///*
        if(node in travelledNode || buffer.any { it.first == node }) {
          //edgeItr.remove()
          continue
        }
        // */
        val travelDistance = Pair(
          node,
          now.second + 6
          //now.third + "-$node",
        )
        val dist = distIndex(node)
        if(distances[dist] == -1 || distances[dist] > travelDistance.second) {
          if(distances[dist] == -1) {
            calculatedDistances++
          } else {
            edgeItr.remove()
          }
          distances[dist] = travelDistance.second
          //if(travelDistance.second == 6) { break }
        }
        if(calculatedDistances == m) {
          break@out
        }
        //println("travelDistance = $travelDistance")
        buffer.add(travelDistance)
        //calculatedDistance++
      }
    }
    edgeItr = mutEdge.listIterator()
  }
  return distances
}

/**
 * Let's assume [edges] is not empty.
 */
fun bfsNodeSearch(
  edgesItr: MutableListIterator<Array<Int>>,
  sharedBuffer: LinkedList<Pair<Int, Int>>,
  dest: Int,
): Int {
  /*
  val buffer = LinkedList<Pair<Int, Int>>().apply {
    push(start to 0)
  }
   */
  println("bfsNodeSearch sharedBuffer= $sharedBuffer")
  val destDistances = mutableListOf<Pair<Int, Int>>()
  val travelledNo = mutableSetOf<Int>()

  var now: Pair<Int, Int>
  while(sharedBuffer.isNotEmpty()) {
    now = sharedBuffer.pop()
    travelledNo += now.first

    for(edge in edgesItr) {
      if(edge[0] == now.first || edge[1] == now.first) {
        val node = if(edge[0] == now.first) edge[1] else edge[0]
        println("node= $node now.first= ${now.first} travelledNo= $travelledNo")
        if(node in travelledNo) {
          continue
        }
        val travelDistance = node to now.second + 6
        if(node == dest) {
          destDistances += travelDistance
        } else {
          sharedBuffer.push(travelDistance)
          edgesItr.remove()
        }
      }
    }
  }
  return if(destDistances.isEmpty()) -1
  else destDistances.minByOrNull { it.second }!!.second
}




fun dfsNode2(
  start: INode,
  destNo: Int,
  travelledNo: MutableSet<Int>? = null,
): Int {
  var distSum = 0
  for(n in start.neighbours) {
    //println("dfsNode2 start= $start n= $n")
    when {
      n.node.no == destNo -> return n.distance
      travelledNo?.let { n.node.no !in it } != false && n.distance > 0 -> {
        val newTravelledNo = (travelledNo ?: mutableSetOf()).apply {
          this += start.no
        }
        val childrenDist = dfsNode2(n.node, destNo, newTravelledNo)
        if(childrenDist > 0) {
          distSum += childrenDist + n.distance
        }
      }
    }
  }
  return distSum
}


fun dfsNode2Routes(start: INode, nodeNo: Int): List<Pair<Int, String>> = routeSearch(
  start, nodeNo, Buffer(Stack()),
)
fun bfsNode2Routes(start: INode, nodeNo: Int): List<Pair<Int, String>> = routeSearch(
  start, nodeNo, Buffer(LinkedList()),
)
fun routeSearch(
  start: INode,
  nodeNo: Int,
  buffer: Buffer<Triple<INode, Int, String>>,
): List<Pair<Int, String>> {
  //println("==== shortestPath - START ======")
  if(start.neighbours.isEmpty()) {
    return emptyList()
  }

  /*
  val queue = LinkedList<Pair<INode, Int>>().apply {
    push(start to 0)
  }
   */
  buffer.push(Triple(start, 0, start.no.toString()))

  val destDistances = mutableListOf<Triple<INode, Int, String>>()
  val travelledNo = mutableSetOf<Int>()
  //val routes = mutableListOf<MutableList<Int>>()
  //var distSum = 0

  var now: Triple<INode, Int, String>
  while(buffer.isNotEmpty()) {
    now = buffer.pop()!!
    //println("now= $now")
    travelledNo += now.first.no
    for(n in now.first.neighbours) {
      //println("n= $n")
      if(n.distance > 0) {
        if(n.node.no in travelledNo) {
          continue
        }
        val travelDistance = Triple(
          n.node,
          now.second + n.distance,
          now.third + "-${n.node.no}"
        )
        if(n.node.no == nodeNo) {
          destDistances += travelDistance
        } else {
          buffer.push(travelDistance)
        }
      }
    }
  }
  //println("destDistances ==== START =====")
  //println("destDistances = ${destDistances.joinToString { "${it.third}:${it.second}" }}")
  return destDistances.map { it.second to it.third }
}

fun bfsSearch(
  startNode: INode,
  no: Int,
): INode? = nodeSearch(
  startNode, no, Buffer(LinkedList()),
)
fun dfsSearch(
  startNode: INode,
  no: Int,
): INode? = nodeSearch(
  startNode, no, Buffer(Stack()),
)
/**
 * Returns [INode] with no of [no] that is connected to [startNode]
 * directly or indirectly via a graph.
 */
fun nodeSearch(
  startNode: INode,
  no: Int,
  buffer: Buffer<INode>,
): INode? {
  if(startNode.neighbours.isEmpty()) {
    return if(startNode.no == no) startNode
    else null
  }

  buffer.push(startNode)
  val travelledNo = mutableSetOf<Int>()
  var now: INode

  while(buffer.isNotEmpty()) {
    now = buffer.pop()!!
    travelledNo += now.no
    for(n in now.neighbours) {
      if(n.distance > 0) {
        if(n.node.no in travelledNo) {
          continue
        }

        if(n.node.no == no) {
          return n.node
        }
        buffer.push(n.node)
      }
    }
  }
  return null
}

/**
 * Returns the distance.
 */
fun bfsNode(edges: Array<Array<Int>>, node: Int): Int {
  TODO()
}

/**
 * Returns the distance.
 */
fun dfsNode(edges: Array<Array<Int>>, node: Int): Int {
  TODO()
  var dist = 0
  for(i in edges) {

  }
  return dist
}