#include <bits/stdc++.h>
using namespace std;

class stackImp
{
    char *data;
    int top;
    int max;

public:
    stackImp(int max)
    {
        data = new char[max];
        top = -1;
        this->max = max;
    }
    void push(char element)
{
    if (top > max)
    {
        cout << "stack is full" << endl;
    }
    else
    {
        data[++top] = element;
    }
}

void rev()
{
    if (top == -1)
    {
        cout << "Stack is empty" << endl;
    }
    else
    {

        for (int temp = top; temp > -1; temp--)
        {
            cout << data[temp];
        }
        cout << endl;
    }
}
    
};

int main()
{
    stackImp s1(12);
    s1.push('R');
    s1.push('a');
    s1.push('m');
    s1.push('e');
    s1.push('s');
    s1.push('h');
    s1.push(' ');
    s1.push('K');
    s1.push('u');
    s1.push('m');
    s1.push('a');
    s1.push('r');
    s1.rev();

    return 0;
}