# include <stdio.h>
# include <stdlib.h>
# include <string.h>
# include <time.h>
#define RANGE 94
void countSort(char **arr, int n,int k)
{
    char ch; // output array
     char output[100][100];
    int count[RANGE + 1], i;
    memset(count, 0, sizeof(count));
    for (i = 0; i < n; i++) {

            ch=arr[i][k];
            count[ch-32]++;

    }


    for (i = 1; i < RANGE+1; i++) {
        count[i] += count[i - 1];
    }

    for (i = n - 1; i >= 0; i--)
    {
            ch=arr[i][k];
            strcpy(output[count[ch-32]-1],arr[i]);
            count[ch-32]--;
    }

    for (i = 0; i < n; i++) {
 strcpy(arr[i],output[i]);
}
}
void radix_sort(char **,int,int);

int main()
{
  char **input;
  char ch=' ';
  int n,k,i,j;
  srand(time(NULL));
  scanf("%d",&n);
  scanf("%d",&k);
  input = (char **)malloc(n*sizeof(char *));
  for(i=0;i<n;i++)
    {
      input[i]=(char *)malloc((k+1)*sizeof(char));
      for(j=0;j<k;j++)
	input[i][j]=(rand()%95)+32;
      input[i][k]='\0';
	printf("%s\t",input[i]);
          printf("\n");
    }
  radix_sort(input,n,k);
  for(i=0;i<n;i++)
    {
      printf("%s\n",input[i]);
    }
  
  return 0;
}

void radix_sort(char **input,int n,int k)
{
  /* The function sorts the array input using radix sort
     Write the two versions of the radix sort here, one after another.
     To execute one of the version just comment out the other version.
   */
int i;
for (i=k-1;i>=0;i--) 
        countSort(input, n,i);

}

