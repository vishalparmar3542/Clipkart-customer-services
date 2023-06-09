#include<iostream>
using namespace std;
int main(){
static int edge,node,i,src_vert,dest_vert,adj[5][5];
cout<<"enter  the number of nodes and edge in the program"<<endl;
cin>>node>>edge;
cout<<"enter the source and destination vertex"<<endl;
for( int i=1;i<=edge ;i++)
{
cin>>src_vert>>dest_vert;
adj[src_vert][dest_vert]=1;

}
cout<<"the matrix is:"<<endl;
for( i=1; i<=node;i++)
{cout << "\n";
for(int j=1;j<=node;j++){

cout<<adj[i][j]<<"\t";
}
}
cout<<endl;

}
