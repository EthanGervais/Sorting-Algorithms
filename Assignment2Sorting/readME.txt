HOW TO USE THE SORT PROGRAM
1. Move the desired shape files into the \Assignment2Sorting\res folder (polyfor1.txt, polyfor3.txt, polyfor5.txt, polyNameBIG.txt).

2. Navigate to the \Assignment2Sorting folder. In the top left of File Explorer, click on the File tab. 
   Then choose Open Windows PowerShell.

3. At the PowerShell prompt, enter "java -jar sort.jar -fFILENAME.txt -tV -sB" (without the quotation marks).

   -f represents the filename
   -t represents the compare type
   -s represents the sort type

   Compare Types:
   v is volume
   h is height
   a is base area

   Sort Types:
   b is bubble
   s is selection
   i is insertion
   m is merge
   q is quick
   z is bogo