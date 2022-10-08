from queue import Queue
from memoria.memoria_procura import MemoriaProcura

class MemoriaFIFO(MemoriaProcura):
    
    def __init__(self):
        fifo_queue = Queue()
        super().__init__(fifo_queue)
