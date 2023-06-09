#include <iostream>
using namespace std;


int HashFunc(int key)
{
    return key % 100;
}

class HashTable
{
private:
    int table[100];

public:
    HashTable()
    {
        for (int i = 0; i < 100; i++)
        {
            table[i] = -1;
        }
    }

    void insert(int key, int value)
    {
        int index = HashFunc(key);
        table[index] = value;
    }

    int search(int key)
    {
        int index = HashFunc(key);
        if (table[index] != -1)
        {
            return table[index];
        }
        else
        {
            return -1;
        }
    }
};

int main()
{
    HashTable hash_table;

    hash_table.insert(123, 456);
    hash_table.insert(456, 789);
    hash_table.insert(789, 123);

    int value1 = hash_table.search(123);
    int value2 = hash_table.search(789);
    int value3 = hash_table.search(512);

    cout << "Value for key 123: " << value1 << endl;
    cout << "Value for key 789: " << value2 << endl;
    cout << "value for key 512: " << value3 << endl;

    return 0;
}