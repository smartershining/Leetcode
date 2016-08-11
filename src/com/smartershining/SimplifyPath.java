package com.smartershining;

import java.util.*;

/**
 * Created by smartershining on 16-8-5.
 */

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();

        while (path.length() > 0 && path.charAt(path.length() - 1) == '/') {
            path = path.substring(0, path.length() - 1);
        }

        int start = 0;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                stack.push(path.substring(start, i));
                start = i;
            } else if (i == path.length() - 1) {
                stack.push(path.substring(start));
            }
        }

        Stack<String> result = new Stack<>();
        int back = 0;
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("/.") || top.equals("/")) {

            } else if (top.equals("/..")) {
                back++;
            } else {
                if (back > 0) {
                    back--;
                } else {
                    result.push(top);
                }

            }

        }

        if (result.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] number = new int[n];
//        for (int i = 0; i < n; i++) {
//            number[i] = scanner.nextInt();
//        }

        String s = "370 349 248 241 304 10 305 106 45 205 292 362 28 244 242 360 266 178 291 198 331 191 104 47 113 117 341 76 202 36 203 363 218 176 110 144 74 128 108 13 278 91 94 61 174 1 222 3 249 30 121 166 290 182 126 351 286 316 229 327 206 326 204 254 72 314 333 319 323 315 53 160 345 243 256 183 115 93 5 18 216 276 60 246 8 171 58 147 134 41 320 197 358 257 9 354 65 83 137 324 34 130 235 70 114 127 274 234 165 175 55 240 87 301 89 338 337 275 43 149 173 187 11 309 95 190 265 303 228 32 164 145 285 232 251 56 271 59 215 289 212 52 24 368 152 22 148 39 80 273 280 223 367 317 26 264 48 336 120 69 210 79 334 357 20 102 270 111 146 356 366 49 329 142 310 279 239 219 122 92 369 124 308 161 192 365 350 7 185 293 226 132 98 284 68 75 33 42 227 340 103 109 50 151 281 253 321 221 263 277 181 359 131 361 96 177 129 302 207 44 54 269 335 73 220 86 194 195 355 84 258 155 297 78 224 67 105 353 209 64 40 141 38 262 261 85 296 71 62 170 188 328 112 4 237 267 342 168 294 186 169 172 125 300 245 138 343 184 347 136 154 318 150 313 14 352 107 364 260 140 306 167 238 116 77 2 199 35 325 200 6 307 211 135 15 143 88 100 214 231 299 230 193 57 159 295 312 311 66 255 17 31 298 158 252 162 21 180 268 81 287 51 247 119 250 225 118 272 282 322 97 133 189 153 156 139 63 208 101 27 213 29 99 217 370 233 344 16 288 19 196 283 201 25 348 46 330 339 157 179 90 163 332 346 236 123 259 82 23 37 12";

        int[] number = new int[]{349, 248, 241, 304, 10, 305, 106, 45, 205, 292, 362, 28, 244, 242, 360, 266, 178, 291, 198, 331, 191, 104, 47, 113, 117, 341, 76, 202, 36, 203, 363, 218, 176, 110, 144, 74, 128, 108, 13, 278, 91, 94, 61, 174, 1, 222, 3, 249, 30, 121, 166, 290, 182, 126, 351, 286, 316, 229, 327, 206, 326, 204, 254, 72, 314, 333, 319, 323, 315, 53, 160, 345, 243, 256, 183, 115, 93, 5, 18, 216, 276, 60, 246, 8, 171, 58, 147, 134, 41, 320, 197, 358, 257, 9, 354, 65, 83, 137, 324, 34, 130, 235, 70, 114, 127, 274, 234, 165, 175, 55, 240, 87, 301, 89, 338, 337, 275, 43, 149, 173, 187, 11, 309, 95, 190, 265, 303, 228, 32, 164, 145, 285, 232, 251, 56, 271, 59, 215, 289, 212, 52, 24, 368, 152, 22, 148, 39, 80, 273, 280, 223, 367, 317, 26, 264, 48, 336, 120, 69, 210, 79, 334, 357, 20, 102, 270, 111, 146, 356, 366, 49, 329, 142, 310, 279, 239, 219, 122, 92, 369, 124, 308, 161, 192, 365, 350, 7, 185, 293, 226, 132, 98, 284, 68, 75, 33, 42, 227, 340, 103, 109, 50, 151, 281, 253, 321, 221, 263, 277, 181, 359, 131, 361, 96, 177, 129, 302, 207, 44, 54, 269, 335, 73, 220, 86, 194, 195, 355, 84, 258, 155, 297, 78, 224, 67, 105, 353, 209, 64, 40, 141, 38, 262, 261, 85, 296, 71, 62, 170, 188, 328, 112, 4, 237, 267, 342, 168, 294, 186, 169, 172, 125, 300, 245, 138, 343, 184, 347, 136, 154, 318, 150, 313, 14, 352, 107, 364, 260, 140, 306, 167, 238, 116, 77, 2, 199, 35, 325, 200, 6, 307, 211, 135, 15, 143, 88, 100, 214, 231, 299, 230, 193, 57, 159, 295, 312, 311, 66, 255, 17, 31, 298, 158, 252, 162, 21, 180, 268, 81, 287, 51, 247, 119, 250, 225, 118, 272, 282, 322, 97, 133, 189, 153, 156, 139, 63, 208, 101, 27, 213, 29, 99, 217, 370, 233, 344, 16, 288, 19, 196, 283, 201, 25, 348, 46, 330, 339, 157, 179, 90, 163, 332, 346, 236, 123, 259, 82, 23, 37, 12};

//        System.out.println(s.replace(" ", ","));
        System.out.println(solve(number));


    }

    public static int solve(int[] number) {
        int result = 0;
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = 0; j < number.length - i - 1; j++) {
                if (number[j] > number[j + 1]) {
                    result++;
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;

                }
            }
        }
        return result;
    }
}