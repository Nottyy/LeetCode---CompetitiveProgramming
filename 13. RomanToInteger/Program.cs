using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _13.RomanToInteger
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(RomanToInt("LVIII"));
        }

        public static int RomanToInt(string s)
        {
            var dict = new Dictionary<char, Tuple<int, Tuple<char,char>>>();
            dict.Add('I', new Tuple<int,Tuple<char,char>>(1, new Tuple<char, char>('V', 'X')));
            dict.Add('V', new Tuple<int,Tuple<char,char>>(5, null));
            dict.Add('X', new Tuple<int,Tuple<char,char>>(10, new Tuple<char, char>('C', 'L')));
            dict.Add('L', new Tuple<int,Tuple<char,char>>(50, null));
            dict.Add('C', new Tuple<int,Tuple<char,char>>(100, new Tuple<char, char>('D', 'M')));
            dict.Add('D', new Tuple<int,Tuple<char,char>>(500, null));
            dict.Add('M', new Tuple<int,Tuple<char,char>>(1000, null));

            var result = 0;

            for (int i = 0; i < s.Length; i++)
            {
                var curChar = s[i];
                var curNum = dict[curChar].Item1;

                if (curChar == 'I' || curChar == 'X' || curChar == 'C')
                {
                    if (i + 1 < s.Length)
                    {
                        var first = dict[curChar].Item2.Item1;
                        var second = dict[curChar].Item2.Item2;
                        if (s[i + 1] == first || s[i+1] == second)
                        {
                            result += dict[s[i + 1]].Item1 - curNum;
                            i++;
                            continue;
                        }
                        else
                        {
                            result += curNum;
                        }
                    }
                    else
                    {
                        result += curNum;
                    }
                }
                else
                {
                    result += curNum;
                }
            }

            return result;
        }
    }
}
