using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace _4.MedianOfTwoSortedArrays
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var first = new int[] { 1, 3 };
            var second = new int[] { 2 };
            Console.WriteLine(FindMedianSortedArrays(first, second));
        }

        public static double FindMedianSortedArrays(int[] nums1, int[] nums2)
        {
            var arr = new int[nums1.Length + nums2.Length];
            var counter1 = 0;
            var counter2 = 0;

            while(true)
            {
                int currentNum1;
                int currentNum2;

                if (counter1 < nums1.Length && counter2 < nums2.Length)
                {
                    currentNum1 = nums1[counter1];
                    currentNum2 = nums2[counter2];

                    if (currentNum1 < currentNum2)
                    {
                        currentNum1 = nums1[counter1];
                        arr[counter1 + counter2] = currentNum1;
                        counter1++;
                    }
                    else
                    {
                        currentNum2 = nums2[counter2];
                        arr[counter2 + counter1] = currentNum2;
                        counter2++;
                    }
                    
                    continue;
                }

                if (counter1 >= nums1.Length)
                {
                    while (counter2 < nums2.Length)
                    {
                        currentNum2 = nums2[counter2];
                        arr[counter2 + counter1] = currentNum2;
                        counter2++;
                    }
                    break;
                }

                if (counter2 >= nums2.Length)
                {
                    while (counter1 < nums1.Length)
                    {
                        currentNum1 = nums1[counter1];
                        arr[counter1 + counter2] = currentNum1;
                        counter1++;
                    }
                    break;
                }
            }
           
            double result;

            if (arr.Length % 2 != 0)
            {
                result = arr[arr.Length / 2];
            }
            else
            {
                double num1 = arr[arr.Length / 2];
                double num2 = arr[(arr.Length / 2) - 1];
                result = (num1 + num2) / 2;

            }
            
            return result;
        }
    }
}
