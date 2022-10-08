import sys
sys.path.append("..")
from procura import ProcuraMelhorPrimeiro
from procura import ProcuraHeuristica


class ProcuraAEstrela(ProcuraMelhorPrimeiro, ProcuraHeuristica):
    

   def f(self, no) :
       '''
       f(n) = g(n) + h(n)

       Parameters
       ----------
       no : No

       Returns
       -------
       TYPE :float
       '''
       return no.get_custo() + super().get_problema().heuristica(no.get_estado())

