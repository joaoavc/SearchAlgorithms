from procura import ProcuraMelhorPrimeiro
from procura import ProcuraHeuristica


class ProcuraCustoUniforme(ProcuraMelhorPrimeiro, ProcuraHeuristica):
    
   def f(self, no) :
       '''
       f(n) = g(n) 

       Parameters
       ----------
       no : No

       Returns
       -------
       TYPE :float
       '''
       return no.get_custo() 

