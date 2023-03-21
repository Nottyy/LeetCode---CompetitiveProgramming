using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace _51.N_Queens
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var res = SolveNQueens(4);

            foreach(var sol in res)
            {
                foreach (var item in sol)
                {
                    Console.WriteLine(item + " ");
                }
                Console.WriteLine();
            }
        }

        public static IList<IList<string>> SolveNQueens(int n)
        {
            var result = new List<IList<string>>();

            var matrix = new bool[n, n];

            PlaceQueen(matrix, 0, result);

            return result;
        }

        public static void PlaceQueen(bool[,] matrix, int row, List<IList<string>> result)
        {
            if (row == matrix.GetLength(0))
            {
                var currentResult = GetSolution(matrix);
                result.Add(currentResult);
                return;
            }

            for (int col = 0; col < matrix.GetLength(0); col++)
            {
                var checkForCollisions = CheckForCollisions(matrix, row, col);
                if (checkForCollisions == false)
                {
                    matrix[row, col] = true;
                    PlaceQueen(matrix, row + 1, result);
                    matrix[row, col] = false;
                }
            }
        }

        private static bool CheckForCollisions(bool[,] matrix, int row, int col)
        {
            // Update row
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                if (matrix[row, i])
                {
                    return true;
                }
            }

            // Update col
            for (int i = 0; i < matrix.GetLength(1); i++)
            {
                if (matrix[i, col])
                {
                    return true;
                }
            }

            // Update diagonals
            return UpdateDiagonal(matrix, row, col, 1, 1) ||
            UpdateDiagonal(matrix, row, col, -1, -1) ||
            UpdateDiagonal(matrix, row, col, 1, -1) ||
            UpdateDiagonal(matrix, row, col, -1, 1);
        }

        private static IList<string> GetSolution(bool[,] matrix)
        {
            var list = new List<string>();
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                var res = "";
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    if (matrix[i, j])
                    {
                        res += 'Q';
                    }
                    else
                    {
                        res += '.';

                    }
                }

                list.Add(res);
            }

            return list;
        }

        private static bool UpdateDiagonal(bool[,] matrix, int row, int col, int dirRow, int dirCol)
        {
            var curRow = row + dirRow;
            var curCol = col + dirCol;
            while (curRow < matrix.GetLength(0) && curRow >= 0 && curCol < matrix.GetLength(1) && curCol >= 0)
            {
                if (matrix[curRow, curCol])
                {
                    return true;
                }

                curRow += dirRow;
                curCol += dirCol;
            }

            return false;
        }
    }
}
