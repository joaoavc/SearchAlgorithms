from procura import ProcuraMelhorPrimeiro


class ProcuraCustoUniforme(ProcuraMelhorPrimeiro):
    
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

