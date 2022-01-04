import java.util.*;
public class Bellman {
static int n,dest;
static double[] distVector,prevDistVector;
static double[][] adjMatrix;
static double min;
public static void main(String[] args) {
Scanner scanner =new Scanner(System.in);
System.out.println("Enter the number of nodes");
n=scanner.nextInt();
adjMatrix=new double[n][n];
System.out.println("Enter the adjacency matrix (use infinite(999) if no edge)");
for(int i=0;i<n;i++) {
for(int j=0;j<n;j++) {
adjMatrix[i][j]=scanner.nextDouble();
if(i==j) {
adjMatrix[i][j]=0;
}
if(adjMatrix[i][j]==999) {
adjMatrix[i][j]=Double.POSITIVE_INFINITY;
}
}
}
System.out.println("Enter the destination node");
dest=scanner.nextInt();
distVector=new double[n];
for(int i=0;i<n;i++) {
distVector[i]=Double.POSITIVE_INFINITY;
distVector[dest-1]=0;
}
for(int i=0;i<n-1;i++) {
prevDistVector=distVector.clone();
for(int j=0;j<n;j++) {
min=Double.POSITIVE_INFINITY;
for(int k=0;k<n;k++) {
if(min>(adjMatrix[j][k])+prevDistVector[k]) {
min=adjMatrix[j][k]+prevDistVector[k];
}
}
distVector[j]=min;
}
}
System.out.println("Distance Vector is");
for(int i=0;i<n;i++) {
System.out.println("Distance from"+(i+1)+"is"+distVector[i]);
}
}
}
