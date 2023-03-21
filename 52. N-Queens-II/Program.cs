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
            Console.WriteLine(TotalNQueens(9));
        }

        public static int TotalNQueens(int n)
        {
            var matrix = new bool[n, n];
            var solutions = PlaceQueen(matrix, 0);

            return solutions;
        }

        private static int PlaceQueen(bool[,] matrix, int row)
        {
            if (row == matrix.GetLength(0))
            {
                return 1;
            }

            var result = 0;

            for (int col = 0; col < matrix.GetLength(1); col++)
            {
                var checkForCollisions = CheckForCollisions(matrix, row, col);

                if (checkForCollisions == false)
                {
                    matrix[row, col] = true;
                    result += PlaceQueen(matrix, row + 1);
                    matrix[row, col] = false;
                }
            }

            return result;
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
