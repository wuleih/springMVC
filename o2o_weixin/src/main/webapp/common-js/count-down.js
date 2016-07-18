/**
 * 倒计时 未完
 */
(function(){
	
	function timer(delay){
		this._queue = [];
		this.stop = false;
		this._createTimer(delay);
	}
	
	timer.prototype = {
			constructor:timer,
			_createTimer:function(delay){
				var self = this;
				var first = true;
				
				(function(){
					var s = new Date();
					for(var i = 0;i < self._queue.length;i++){
						self._queue[i]();
					}
					
					if(!self.stop){
						var cost = new Date()-s;
						delay = first ? delay : ((cost > delay)?cost-delay:delay);
						setTimeout(argument.callee,delay);
					}
					
				})();
				first = false;
			},
			
			add:function(cb){
				this._queue.push(cb);
				this.stop = false;
				return this._queue.length-1;
			},
			
			remove:function(index){
				this._queue.splice(index,1);
				if(!this._queue.length){
					this.stop = true;
				}
			}
	}
	
	
	
})();