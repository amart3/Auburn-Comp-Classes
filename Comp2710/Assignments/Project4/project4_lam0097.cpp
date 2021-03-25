// AUTHOR: Lawrence "Alex" Martin
//Project 4
//Code typed on my laptop using Visual Studio Code. 



#include <iostream>
#include <assert.h>

using namespace std;

//creates two versions
#define UNIT_TESTING
#define trivia_quiz
//struct that holds trivia question, answer, and points
struct TriviaNode {
    string question, answer;
    int points, amount;
    TriviaNode *next;
    TriviaNode *head;
    TriviaNode * tail;
};
typedef TriviaNode* ptr_node;
//puts the three questions into linked list
void init_question_list(ptr_node& q_list) {
    string bob;
    ptr_node cur_ptr1 = new TriviaNode;
    ptr_node cur_ptr2 = new TriviaNode;
    ptr_node cur_ptr3 = new TriviaNode;

    cur_ptr1 -> question = "How long was the shortest war on record? (Hint: how many minutes)";
    cur_ptr1 -> answer = "38";
    cur_ptr1 -> points = 100;
    cur_ptr1 -> next = cur_ptr2;

    cur_ptr2 -> question = "What was Bank of Americas original name? (Hint: Bank of Italy or Bank of Germany)";
    cur_ptr2 -> answer = "Bank of Italy";
    cur_ptr2 -> points = 50;
    cur_ptr2 -> next = cur_ptr3;

    cur_ptr3 -> question = "What is the best-selling video game of all time? (Hint: Call of Duty or Wii Sports)?";
    cur_ptr3 -> answer = "Wii Sports";
    cur_ptr3 -> points = 20;
    cur_ptr3 -> next = NULL;

    q_list -> head = cur_ptr1;
    q_list -> tail = cur_ptr3;
    q_list -> amount += 3;
}
//allows the user to add a new question to the linked list;
void add_question(ptr_node& q_list) {
  string reply;
  do {
    q_list -> amount++;
    TriviaNode *t = new TriviaNode;
    cout << "Enter a question: ";
    getline(cin, t -> question);
    cout << "Enter an answer: ";
    getline(cin, t -> answer);
    cout << "Enter award points: ";
    cin >> t -> points;

    cout << "Continue? (Yes/No): ";
    getline(cin.ignore(), reply);
    q_list -> tail -> next = t;
    q_list -> tail = t;

  }

  while (reply == "Yes" || reply == "yes");
}

int ask_question(ptr_node q_list, int num_ask) {
    TriviaNode *cur_ptr = q_list -> head;
    int totalPoints = 0;
    string userInput;
    if (q_list == NULL) {
        return 0;
    }
    if (num_ask < 1) {
        cout << "Warning - the number of trivia to be asked must equal to or be larger than 1.";
    }
    else if(num_ask > q_list -> amount) {
        cout << "Warning - There is only " << q_list -> amount << " trivia in the list.";
    }

    else {
        for (int x = 0; x < num_ask; x++) {
            cout << "\nQuestion: " << cur_ptr -> question << endl;
            cout << "Answer: ";
            getline(cin, userInput);


            if (userInput.compare(cur_ptr -> answer) == 0) {
                cout << "Your answer is correct. You receive " << cur_ptr -> points << " points.";
                totalPoints += cur_ptr -> points;
            }
            else {
                cout << "Your answer is wrong. The correct answer is " << cur_ptr -> answer;
            }
            cout << "\nYour Total Points: " << totalPoints << endl;
            cur_ptr = cur_ptr -> next;
        }
        return 0;
    }
}
//test cases for ask_Question method
void test_ask_question() {
    ptr_node tNode = new TriviaNode;
    init_question_list(tNode);

    cout << "Unit Test Case 1: Ask no question. The program should give a warning message." << endl;
    ask_question(tNode, 0);
    cout << "\nCase 1 Passed\n\n";

    cout << "Unit Test Case 2.1: Ask 1 question in the linked list. The tester enters an incorrect answer." << endl;
    ask_question(tNode, 1);
    cout << "\nCase 2.1 passed\n\n";

    cout << "Unit Test Case 2.2: Ask 1 question in the linked list the tester enters a correct answer" << endl;
    ask_question(tNode, 1);
    cout << "\nCase 2.2 passed\n\n";

    cout << "Unit Case 3: Ask all the questions of the last trivia in the linked list."<< endl;
    ask_question(tNode, 3);
    cout << "\nCase 3 passed\n\n";

    cout << "Unit Test Case 4: Ask 5 questions in the linked list." << endl;
    ask_question(tNode, 5);
    cout << "\nCase 4 passed\n\n";

    cout << "*** End of the Debugging Version ***";
}
#ifdef UNIT_TESTING
    void test_ask_question();
#endif
//main function of program
int main(){
    #ifdef UNIT_TESTING
        cout << "*** This is the debugging version ***\n";
        test_ask_question();
        cout << "*** End of the debugging version ***\n";
    #else
    cout << "*** Welcome to Alex's trivia quiz game ***\n";
    ptr_node triv = new TriviaNode;
    int bPoints;
    init_question_list(triv);
    add_question(triv);

    //cout << "\n" << endl;
    ask_question(triv, triv-> amount);
    cout << "\n*** Thank you for playing the trivia quiz game. Goodbye! *** ";



    #endif
    return 0;

}