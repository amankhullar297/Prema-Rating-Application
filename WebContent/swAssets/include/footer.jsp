
<!--Footer-->
<footer id="footer">
	<div class="container">

		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-12">
				<div class="single_footer">
					<h2>Prema Software Solutions</h2>
					<ul>
						<li><a href="">@: sales@premasoftware.com</a></li>
						<li><a href="">p: +91-98260 72634</a></li>
						<li><a href="">a: Prema Softwares Pvt Ltd. 35-B, Behind
								Indian Coffee House, Indrapuri, Bhopal, India. </a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<div class="single_footer">
					<h2>Company</h2>
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="aboutus.jsp">About Us</a></li>
						<li><a href="pricing.jsp">Pricing</a></li>
						<li><a href="contact.jsp">Contact Us</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<div class="single_footer">
					<h2>Others</h2>
					<ul>
						<li><a href="">Help & Support</a></li>
						<li><a href="">Privacy Policy</a></li>
						<li><a href="">Terms</a></li>
						<li><a href="">Sitemap</a></li>
					</ul>
				</div>
			</div>


			<div class="col-md-3 col-sm-3 col-xs-12">
				<div class="single_footer">
					<h2>Newsletter</h2>
					<p>Subscribe to our newsletter and get all the cool news</p>

					<form class="navbar-form navbar-left email_sender" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit">
							<i class="fa fa-paper-plane-o"></i>
						</button>
					</form>

				</div>
			</div>

		</div>

		<div class="footer_bottom">
			<div class="row">
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="single_footer_bottom">
						<p class="wow zoomIn" data-wow-duration="1s">
						<!-- style="color:#6FB048" -->
							Made with <i class="fa fa-heart"></i> at <a
								href="http://www.cadcust.com/index.html">Prema Software Solutions</a>2018. All
							Rights Reserved
						</p>
					</div>
				</div>

				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="single_footer_bottom pull-right">
						<ul>
							<li><a href="" class="s_f_1"><i class="fa fa-twitter"></i></a></li>
							<li><a href="" class="s_f_2"><i class="fa fa-facebook"></i></a></li>
							<li><a href="" class="s_f_3"><i class="fa fa-instagram"></i></a></li>
							<li><a href="" class="s_f_4"><i class="fa fa-dribbble"></i></a></li>
							<li><a href="" class="s_f_5"><i class="fa fa-github"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- End footer bottom -->
	</div>
</footer>


<script src="swAssets/js/vendor/jquery-1.11.2.min.js"></script>
<script src="swAssets/js/vendor/bootstrap.min.js"></script>

<script src="swAssets/js/jquery.easing.1.3.js"></script>
<script src="swAssets/js/wow.min.js"></script>
<script src="swAssets/js/plugins.js"></script>
<script src="swAssets/js/main.js"></script>


	<script>


	var __slice = [].slice;

	(function($, window) {
	  var Starrr;

	  Starrr = (function() {
		Starrr.prototype.defaults = {
		  rating: void 0,
		  numStars: 5,
		  change: function(e, value) {}
		};

		function Starrr($el, options) {
		  var i, _, _ref,
			_this = this;

		  this.options = $.extend({}, this.defaults, options);
		  this.$el = $el;
		  _ref = this.defaults;
		  for (i in _ref) {
			_ = _ref[i];
			if (this.$el.data(i) != null) {
			  this.options[i] = this.$el.data(i);
			}
		  }
		  this.createStars();
		  this.syncRating();
		  this.$el.on('mouseover.starrr', 'span', function(e) {
			return _this.syncRating(_this.$el.find('span').index(e.currentTarget) + 1);
		  });
		  this.$el.on('mouseout.starrr', function() {
			return _this.syncRating();
		  });
		  this.$el.on('click.starrr', 'span', function(e) {
			return _this.setRating(_this.$el.find('span').index(e.currentTarget) + 1);
		  });
		  this.$el.on('starrr:change', this.options.change);
		}

		Starrr.prototype.createStars = function() {
		  var _i, _ref, _results;

		  _results = [];
		  for (_i = 1, _ref = this.options.numStars; 1 <= _ref ? _i <= _ref : _i >= _ref; 1 <= _ref ? _i++ : _i--) {
			_results.push(this.$el.append("<span class='glyphicon .glyphicon-star-empty'></span>"));
		  }
		  return _results;
		};

		Starrr.prototype.setRating = function(rating) {
		  if (this.options.rating === rating) {
			rating = void 0;
		  }
		  this.options.rating = rating;
		  this.syncRating();
		  return this.$el.trigger('starrr:change', rating);
		};

		Starrr.prototype.syncRating = function(rating) {
		  var i, _i, _j, _ref;

		  rating || (rating = this.options.rating);
		  if (rating) {
			for (i = _i = 0, _ref = rating - 1; 0 <= _ref ? _i <= _ref : _i >= _ref; i = 0 <= _ref ? ++_i : --_i) {
			  this.$el.find('span').eq(i).removeClass('glyphicon-star-empty').addClass('glyphicon-star');
			}
		  }
		  if (rating && rating < 5) {
			for (i = _j = rating; rating <= 4 ? _j <= 4 : _j >= 4; i = rating <= 4 ? ++_j : --_j) {
			  this.$el.find('span').eq(i).removeClass('glyphicon-star').addClass('glyphicon-star-empty');
			}
		  }
		  if (!rating) {
			return this.$el.find('span').removeClass('glyphicon-star').addClass('glyphicon-star-empty');
		  }
		};

		return Starrr;

	  })();
	  return $.fn.extend({
		starrr: function() {
		  var args, option;

		  option = arguments[0], args = 2 <= arguments.length ? __slice.call(arguments, 1) : [];
		  return this.each(function() {
			var data;

			data = $(this).data('star-rating');
			if (!data) {
			  $(this).data('star-rating', (data = new Starrr($(this), option)));
			}
			if (typeof option === 'string') {
			  return data[option].apply(data, args);
			}
		  });
		}
	  });
	})(window.jQuery, window);

	$(function() {
	  return $(".starrr").starrr();
	});

	$( document ).ready(function() {
		  
	  $('#stars').on('starrr:change', function(e, value){
		$('#count').html(value);
	  });
	  
	  $('#stars-existing').on('starrr:change', function(e, value){
		$('#count-existing').html(value);
	  });
	});
	</script>
</body>
</html>
