//Author: Lawrence "Alex" Martin (lam0097)input
//Project 3
//Code typed on my laptop using Visual Studio Code. 

#include <iostream>
#include <fstream>
#include <cstdlib>
using namespace std;

const int MAX_SIZE = 100;

//function reads file
int readFile(int inputArray[], ifstream& instream) {
   if (instream.fail()) {
      cout << "Input file opening failed." << endl;
      return -1;
   }
   int index = 0;

   instream >> inputArray[index];
   while (! instream.eof()) {
      index++;
      instream >> inputArray[index];
   }

   return index;


}
//sort array least to greatest
int sort(int inputArray[], int inputArray1_size, int inputArray2[], int inputArray2_size, int outputArray[]) {
   int i = 0;
   int k = 0;
   int j = 0;
   int p = 0;

   while (i < inputArray1_size && k < inputArray2_size) {
      if (inputArray[i] <= inputArray2[k]) {
         outputArray[j] = inputArray[i];
         i++;
      }
      else {
         outputArray[j] = inputArray2[k];
         k++;
      }
      j++;
   }

   if (i < inputArray1_size) {
      for (p = i; p < inputArray1_size; p++) {
         outputArray[j] = inputArray[p];
         j++;
      }
   }
   
   else {
      for (p = k; p < inputArray2_size; p++ ) {
         outputArray[j] = inputArray2[p];
         j++;
      }
   }

   return j;
}
//write new file
void writeFile(int outputArray[], int outputArray_size, string fileName) {
   ofstream output;
   output.open(fileName.c_str());
   for (int i = 0; i < outputArray_size; i++){
      output << outputArray[i] << endl;
   
   }
   output.close();

}

//The main function of the program.
int main()
{
   int aSize1 = 0;
   int aSize2 = 0;
   int array1[MAX_SIZE];
   int array2[MAX_SIZE];


   int newArray[MAX_SIZE];

   string file1, file2, file3;
   cout << "*** Welcome to Alex's sorting program ***\n";
   cout << "Enter the first input file name: ";
   cin >> file1;




   ifstream in1;
   in1.open(file1.c_str());
   aSize1 = readFile(array1, in1);
   cout << "The list of " << aSize1 <<   " numbers in file ";
   cout << file1 << " is: \n";
   for (int i =0; i < aSize1; i++) {
      cout << array1[i] << "\n";
   }
   in1.close();

   cout << "\nEnter the second input file name: ";
   cin >> file2;
   ifstream in2;

   in2.open(file2.c_str());
   aSize2 = readFile(array2, in2);
   cout << "The list of " << aSize2 << " numbers in file ";
   cout << file2 << " is: \n";
   for (int i = 0; i < aSize2; i++) {
      cout << array2[i] << "\n";
   }
   in2.close();

   int outSize = sort(array1, aSize1, array2, aSize2, newArray);
   cout << "The sorted list of " << outSize << " numbers is: ";
   for (int i = 0; i < outSize; i++) {
      cout << newArray[i] << " ";
   }
   cout << "\n\nEnter the output file name: ";
   cin >> file3;
   writeFile(newArray, outSize, file3);
   cout << "*** Please check the new file - " << file3 <<  " ***";
   cout << "\n*** Goodbye. ***";
   in1.close();
   in2.close();
   return 0;

}

