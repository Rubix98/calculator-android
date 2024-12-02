#include <jni.h>
#include <iostream>
#include <string>
#include <set>
#include <vector>
using namespace std;

const vector<set<char>> OPERATORS = {{'+', '-'}, {'*', '/'}};

vector<string> splitOperationByOperators(string operation, set<char> operators) {
    vector<string> result;
    int last = 0;
    for (int i = 0; i < operation.size(); i++) {
        if (operators.find(operation[i]) != operators.end()) {
            result.push_back(operation.substr(last, i-last));
            result.push_back(string(1, operation[i]));
            last = i+1;
        }
    }
    result.push_back(operation.substr(last, operation.size()-last));
    return result;
}

double doMath(double num1, string op, double num2) {
    if (op == "+") return num1 + num2;
    if (op == "-") return num1 - num2;
    if (op == "*") return num1 * num2;
    if (op == "/") return num1 / num2;
    return 0;
}

double calculateReq(string operation, int q = 0) {
    if (q == OPERATORS.size()) {
        return stod(operation);
    }

    vector<string> tokens = splitOperationByOperators(operation, OPERATORS[q]);
    double result = calculateReq(tokens[0], q+1);
    for (int i = 1; i < tokens.size(); i += 2) {
        result = doMath(result, tokens[i], calculateReq(tokens[i+1], q+1));
    }

    return result;
}

string jstringToString(JNIEnv *env, jstring arg) {
    jboolean isCopy;
    const char *convertedValue = (env)->GetStringUTFChars(arg, &isCopy);
    return (string)convertedValue;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_pl_marcinwojdat_calculatorapplication_CalculatorService_calculate(JNIEnv *env, jobject thiz, jstring arg) {
    string operation = jstringToString(env, arg);
    if (operation.empty()) return 0;
    if (operation[0] == '-') operation = "0" + operation;
    return calculateReq(operation);
}

