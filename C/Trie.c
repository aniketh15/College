#include<stdio.h>
#include<string.h>
#include<stdlib.h>
typedef struct node
{
	char ch;
	int flag;
	struct node *list[26];
}*trie;

void insert(trie letter,char *str);
int search(trie head, char *key);
int check(char *s);

int main()
{
	trie head = (trie)malloc(sizeof(struct node));
	int i,n,valid,ctr=0,f=0;
	for(i=0;i<26;i++)
		head->list[i]=NULL;
	head->flag=0;
	char str[20];
	while(1)
	{
		printf("\nMenu.\n\t0.Exit\n\t1.Insert a word.\n\t2.Search a word.\n\t3.Number of words in the trie.\n\nEnter a Choice:");
		scanf("%d",&n);
		switch(n)
		{
			case 0 : 
				{
					printf("\nThank you\n");
					exit(0);
				}
			case 1 :
				{
			 		 printf("\nEnter word to be inserted: ");
			         scanf("%s",str);
			         valid=check(str);
			         if(valid)
			         {
			         	if(search(head,str))
			         		printf("\n%s is already present in the trie\n",str);
			         	else
			         	{
							insert(head,str);
							ctr++;
						}
					 }
					 else
						printf("Invalid string! Only words with lower case characters can be inserted.\n\n");
					 break;
				}
			case 2 : 
				{
					 printf("\nEnter word to be searched: ");
			         scanf("%s",str);
			         valid=check(str);
			         if(valid)
					 {
			         	f = search(head,str);
			            if(f)
			         		printf("\n%s is present in the trie\n",str);
						else
					 		printf("\n%s is NOT present in the trie\n",str);
					 }
					 else
						printf("Invalid string! Only words with lower case characters can be searched.\n\n");
			         break;
			    }
			case 3 :
				{
					 printf("\nThe number of words in the trie= %d\n",ctr);
					 break;
				}
		    default :
				{
					 printf("Invalid choice\n");
				}
		}
	}
	return 0;
}

//inserts a word in the trie
void insert(trie letter,char *str)
{
	trie temp;
	int i=0,j;
	for(i=0;i<strlen(str);i++)
	{
		if(letter->list[str[i]-97])
		{
			letter =letter->list[str[i]-97];
			continue;
		}
		else
		{
			temp=(trie)malloc(sizeof(struct node));
			temp->ch=str[i];
			for(j=0;j<26;j++)
				temp->list[j]=NULL;
			temp->flag=0;
			letter->list[str[i]-97]=temp;
			letter =temp;
		}
	}
	letter->flag=1;
}

// searches for a word in the trie. If present returns 1 else returns 0
int search(trie head, char *key)
{
	int i=0;
    for(i=0;i<strlen(key);i++)
   {
   		if(head->list[key[i]-97] == NULL)
      		return 0;
     	else
      		head=head->list[key[i]-97];
	}
	if(head->flag==1)
      return 1;
	else
      return 0;
   
}

// checks if the string is valid so that it can be inserted or searched
int check(char *s)
{
	int i;
	for(i=0;i<strlen(s);i++)
	{
		if(!(((s[i])>='a') && ((s[i])<='z')))
			return 0;
	}
	return 1;
}
